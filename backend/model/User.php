<?php

  class User implements JsonSerializable {
    
    private $id;
    private $name;
    private $surname;
    private $birthdate;
    private $login;
    private $password;

    public function __construct(){}

    public function getId() 
    {
      return $this->id;
    }

    public function setId($id)
    {
      $this->id = $id;
    }

    public function getName() 
    {
      return $this->name;
    }

    public function setName($name)
    {
      $this->name = $name;
    }

    public function getSurname() 
    {
      return $this->surname;
    }

    public function setSurname($surname)
    {
      $this->surname = $surname;
    }

    public function getBirthdate() 
    {
      return $this->birthdate;
    }

    public function setBirthdate($birthdate)
    {
      $this->birthdate = $birthdate;
    }

    public function getLogin() 
    {
      return $this->login;
    }

    public function setLogin($login)
    {
      $this->login = $login;
    }

    public function getPassword() 
    {
      return $this->password;
    }

    public function setPassword($password)
    {
      $this->password = $password;
    }

    public function jsonSerialize()
    {
      return 
      [
        'id'        => $this->getId(),
        'name'      => $this->getName(),
        'surname'   => $this->getSurname(),
        'birthdate' => $this->getBirthdate(),
        'login'     => $this->getLogin(),
        'password'  => $this->getPassword()
      ];
    }

  }
