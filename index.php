<?php

    $sessionId = $_POST['sessionId'];
	$serviceCode   = $_POST['serviceCode'];
	$phoneNumber   = $_POST['phoneNumber'];
	$text          = $_POST['text'];
    $ENDPOINT = 'http://d42c-105-234-164-28.ngrok.io/php%20ussd/';

    $ussd_string_exploded = explode('*', $text);
    $level = count($ussd_string_exploded);

    $response = "";
    if ($text == "") {
         
        $response = "CON choose operation \n 1.check balance \n 2.send money \n 3.make payments \n 4.airtime topup \n 5.pin change \n 6.exit";
    }elseif ($text == "1") {
        $url = $ENDPOINT."checkBalance.php";
        $ch = curl_init();
        curl_setopt($ch, CURLOPT_POST, 1);
        curl_setopt($ch, CURLOPT_POSTFIELDS, ['id' => 1]);
        curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);
        curl_setopt($ch, CURLOPT_URL, $url);
        $result = curl_exec($ch);
        $response = "CON 1. your balance is K".$result;
    }elseif ($text == "2") {
        $response = "CON 1. to account \n 2. to phone number \n";
        $response .= "0:Back\n";
    }elseif ($text == "2*1") {
        $response = "CON Enter account number" . $phoneNumber;
    }elseif ($text == "2*2") {
        $response = "CON 1. to airtel money \n 2. to tnm mpamba";
    }elseif ($text=="2*2*1") {
        $response = "CON Enter the airtel number";
    }elseif ($text=="2*2*2") {
        $response = "CON Enter the tnm number";
    }
    elseif ($level >= 3) {
        //str_starts_with($text, "2*2*1*")
        //$num = substr($text, 4);
        $response = $text;

        //sendMoney()
    }
    elseif ($ussd_string_exploded[0] = 1 && $ussd_string_exploded[1] = 2 && $ussd_string_exploded[2] = 1 && $level = 4) {
        $response = "END ZATHEKA";
    } 
    //    $response = "";
    // if ($text == "") {
    //     $response = "CON choose operation \n 1.send money \n 2.check balance \n 3. make payments";
    // }elseif ($text == "1") {
    //     $response = "CON 1. to account \n 2. to phone number";
    // }elseif ($text == "1*2") {
    //     $response = "CON 1. to airtel money \n 2. to tnm mpamba";
    // }elseif ($text == "1*2*1") {
    //     $response = "CON Enter the airtel number";
    // }elseif ($text == "1*2*2") {
    //     $response = "CON Enter the tnm number";
    // }elseif ($ussd_string_exploded[0] = 1 && $ussd_string_exploded[1] = 2 && $ussd_string_exploded[2] = 1 && $level = 4) {
    //     $response = "END ZATHEKA";
    // }



    header('Content-type: text/plain');
	echo $response;






    // $sessionId = $_POST['sessionId'];
	// $serviceCode   = $_POST['serviceCode'];
	// $phoneNumber   = $_POST['phoneNumber'];
	// $text          = $_POST['text'];

    // $ussd_string_exploded = explode('*', $text);
    // $level = count($ussd_string_exploded);

    // $response = "";
    // if ($text == "") {
    //     $response = "CON choose operation \n 1.check balance \n 2.send money \n 3.make payments \n 4.airtime topup \n 5.pin change \n 6.exit";
    // }elseif ($text == "1") {
    //     $response = "CON 1. your balance is k3000";
    // }elseif ($text == "2") {
    //     $response = "CON 1. to account \n 2. to phone number";
    // }elseif ($text == "2*1") {
    //     $response = "CON Enter account number";
    // }elseif ($text == "2*2") {
    //     $response = "CON 1. to airtel money \n 2. to tnm mpamba";
    // }elseif ($text=="2*2*1") {
    //     $response = "CON Enter the airtel number";
    // }elseif ($text=="2*2*2") {
    //     $response = "CON Enter the tnm number";
    // }
    // elseif ($ussd_string_exploded[0] = 1 && $ussd_string_exploded[1] = 2 && $ussd_string_exploded[2] = 1 && $level = 4) {
    //     $response = "END ZATHEKA";
    // } 
//elseif ($ussd_string_explode
  // elseif ($ussd_string_exploded[0] = 1 && $ussd_string_exploded[1] = 2 && $ussd_string_exploded[2] = 1 && $level = 4) {
    //     $response = "END ZATHEKA";
    //    $response = "";
    // if ($text == "") {
    //     $response = "CON choose operation \n 1.send money \n 2.check balance \n 3. make payments";
    // }elseif ($text == "1") {
    //     $response = "CON 1. to account \n 2. to pehone number";
    // }elseif ($text == "1*2") {
    //     $response = "CON 1. to airtel money \n 2. to tnm mpamba";
    // }elseif ($text == "1*2*1") {
    //     $response = "CON Enter the airtel number";
    // }elseif ($text == "1*2*2") {
    //     $response = "CON Enter the tnm number";
    // }elseif ($ussd_string_exploded[0] = 1 && $ussd_string_exploded[1] = 2 && $ussd_string_exploded[2] = 1 && $level = 4) {
    //     $response = "END ZATHEKA";
    // }



//     header('Content-type: text/plain');
// 	echo $response;
// 

function sendMoney($target, $amount)
{
    $url = $ENDPOINT."sendMoney.php";
        $ch = curl_init();
        curl_setopt($ch, CURLOPT_POST, 1);
        curl_setopt($ch, CURLOPT_POSTFIELDS, ['target_number' => $target, "amount" => $amount, "user_number" => $phoneNumber]);
        curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);
        curl_setopt($ch, CURLOPT_URL, $url);
        $result = curl_exec($ch);
}

?>