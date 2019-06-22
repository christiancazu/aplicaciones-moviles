<?php

	include_once 'controller/UserController.php';
	include_once 'config/Response.php';

	$request = $_GET['request']; 

	switch ($request) {
		
		case 'authenticate':		
			$login = isset($_GET['login']) ? $_GET['login'] : '';
			$password = isset($_GET['password']) ? $_GET['password'] : '';
		
			if (validateParameters($login, $password)) {
				$userController = new UserController();
				$userController->authenticate($login, $password);	
			}
		break;

		case 'user':
			$token = isset($_GET['token']) ? $_GET['token'] : '';
			$userController = new UserController();
			$userController->getUser($token);
		break;

		default:
			$response = new Response('resource no found', 404);
			$response->getResponse();		
	}	
	

	function validateParameters($login, $password) 
	{
		if ($login == '') {
			$response = new Response('the field login is required', 400);
			$response->getResponse();
			return false;
		} 
		if ($password == ''){
			$response = new Response('the field password is required', 400);
			$response->getResponse();
			return false;
		}
		return true;		
	}
	