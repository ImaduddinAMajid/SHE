<?php

class Database
{
    private static $dbName = '';
    private static $dbHost = '';
    private static $dbUsername = '';
    private static $dbPassword = '';

    private static $cont = null;

    public function __construct()
    {
        die('Init function is not allowed');
    }

    public static function connect()
    {
        if (null == self::$cont)
        {
            try
            {
                self::$cont = new PDO("mysql:host=".self::$dbHost.";"."dbname=".self::$dbName, self::$dbUsername, self::$dbPassword);
            }
            catch (PDOException $e)
            {
                die($e->getMessage());
            }
        }
        return self::$cont;
    }
    public static function disconnect()
    {
        self::$cont = null;
    }
}
?>
