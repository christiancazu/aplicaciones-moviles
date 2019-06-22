<?php

  include_once 'config/Database.php';
  include_once 'config/Response.php';
  include_once 'helpers/TokenGenerator.php';
  include_once 'model/User.php';

  class UserController 
  {
    private $db;
    private $conn;
    private $response;

    public function __construct()
    {
      $this->db = new Database();
	    $this->conn = $this->db->getConnection();
    }

    public function authenticate($login, $password) 
    {
      $sql = 
          "SELECT * 
          FROM user 
          WHERE login = '$login' 
          AND password = '$password'";

      $stmt = $this->conn->prepare($sql);
      $stmt->execute();

      $result = $stmt->fetch(PDO::FETCH_ASSOC);

      if (!$result) {
        $this->response = new Response('invalid credentials', 400);
      } else {
        $token = $this->assignTokenToUser($result['id']);      

        $this->response = new Response(['token' => $token]);
      }      

      $stmt = null;
      $this->db->closeConnection();

      return $this->response->getResponse();
    }

    private function assignTokenToUser($id) 
    {
      $token = TokenGenerator::generateToken();

      $sql = 
          "UPDATE user 
          SET token='$token'
          WHERE id = :id";

      try {
        $stmt = $this->conn->prepare($sql);
        $stmt->bindParam(':id', $id);
        $stmt->execute();
        $stmt = null;

        return $token;        
      } catch (\Throwable $th) {
        // TODO: handle error
        $this->response = new Response('server error', 500);
      }      
    }

    public function getUser($token)
    {
      $sql = 
          "SELECT * 
          FROM user 
          WHERE token = '$token'";

      $stmt = $this->conn->prepare($sql);
      $stmt->execute();

      $result = $stmt->fetch(PDO::FETCH_ASSOC);

      if (!$result) {
        $this->response = new Response('invalid session', 401);
      } else {       
        $this->response = new Response(new User($result));
      }      

      $stmt = null;
      $this->db->closeConnection();

      return $this->response->getResponse();
    }

  }
