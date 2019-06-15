<?php

  class Response {

    private $body;    
    private $status;

    public function __construct($body, $status = 200)
    {
      $this->body = $body;
      $this->status = $status;
    }
      
    public function getResponse()
    {
      header_remove();
      http_response_code($this->status);
      header('Content-Type: application/json');

      if ($this->status != 200) {
        echo json_encode(['error' => $this->body]);
      } else {
        echo json_encode($this->body);
      }
    }
  }
