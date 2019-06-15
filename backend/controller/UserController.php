<?php

  include_once 'config/Database.php';
  include_once 'config/Response.php';
  include_once 'model/User.php';

  class UserController {

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
          WHERE login = '$login' AND password = '$password'";

      $stmt = $this->conn->prepare($sql);
      $stmt->execute();

      $result = $stmt->fetch((PDO::FETCH_ASSOC));

      if (!$result) {
        $this->response = new Response('invalid credentials', 400);
      } else {
        $this->response = new Response($this->setUser($result));
      }      

      $stmt = null;
      $this->db->closeConnection();

      return $this->response->getResponse();
    }

    public function setUser($result) 
    {
      $user = new User();
      $user->setId($result['id']);
      $user->setName($result['name']);
      $user->setSurname($result['surname']);
      $user->setBirthdate($result['birthdate']);
      $user->setLogin($result['login']);
      $user->setPassword($result['password']); 
      
      return $user;
    }

  }
