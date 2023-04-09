
//// Take the JSON String and Create a populated JSONObject
//        //JSONObject phaUserJSONObject = new JSONObject(phaUserJSONString);
//        // Attempt to validate the JSON Object. Validation errors are tracked in the object
//        PHAPersonValidationStatusAndMessage jsonObjectValidationStatusAndMessage = PHAPersonValidator.validateEntireUserJSONObject(phaUserJSONObject);
//
//        // If The Validation Does Not Pass...
//        if (!jsonObjectValidationStatusAndMessage.getWasDataValidationSuccess()) {
//
//            // Create a map to hold data validation status codes and messages
//            HashMap dataValidationHashMap = new HashMap<String, String>();
//
//            // Put a custom message into the Hash Map
//            dataValidationHashMap.put("validation-status", jsonObjectValidationStatusAndMessage.getDataValidationMessage());
//
//            //Response with an error HTTP code and the validation status messages.
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(dataValidationHashMap.toString());
//        }
//
//        JMSQueueProducer jmsQueueProducer = new JMSQueueProducer(host, port, queueName);
//        jmsQueueProducer.sendMessage(PHAPersonHelper.transformPHAPersonToNestedJSON(PHAPersonHelper.unmarshallDataFromJSONToPHAPerson(phaUserJSONObject)).toString());
//
//        return ResponseEntity.status(HttpStatus.OK).body("");

