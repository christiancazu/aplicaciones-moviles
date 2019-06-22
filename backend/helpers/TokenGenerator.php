<?php

  class TokenGenerator
  {
    static $characters = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';
    static $tokenLength = 64;

    public static function generateToken() {
      $charactersLength = strlen(self::$characters);
      $randomString = '';
      for ($i = 0; $i < self::$tokenLength; $i++) {
          $randomString .= self::$characters[rand(0, $charactersLength - 1)];
      }
      return $randomString;
    }

  }
