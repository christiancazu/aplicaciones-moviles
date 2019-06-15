<?php

  include_once 'Response.php';

  class Database {
    
    private $host;
    private $database;
    private $user;
    private $password;
    private $conn;

    public function __construct()
    {
      $this->host = 'localhost';
      $this->database = 'appmovil_api';
      $this->user = 'root';
      $this->password = '';
      $this->conn = null;      
    }

    public function getConnection()
    {      
      try {
        $connection = "mysql:host=" . $this->host . ";dbname=" . $this->database;

        $this->conn = new PDO($connection, $this->user, $this->password);
        $this->conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

      } catch (PDOException $e) {
        $response = new Response('database connection failed', 500);
        return $response->getResponse();
      }
      return $this->conn;
    }

    public function closeConnection() 
    {
      $this->conn = null;
    }
  }
