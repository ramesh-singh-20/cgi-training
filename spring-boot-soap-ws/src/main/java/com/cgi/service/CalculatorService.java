package com.cgi.service;

import com.cgi.spring.soap.api.calculator.CalculateRequest;
import com.cgi.spring.soap.api.calculator.CalculateResponse;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {


    public CalculateResponse calculate(CalculateRequest request){
        int num1= request.getNumOne();
        int num2= request.getNumTwo();
        String operation= request.getOperation();
        CalculateResponse response= new CalculateResponse();
        response.setNumOne(num1);
        response.setNumTwo(num2);
        response.setOperation(operation);

        if(operation.equals("+")){
            response.setResult(num1+num2);
        }
        else if(operation.equals("-")){
            response.setResult(num1-num2);
        }
        else if(operation.equals("*")){
            response.setResult(num1*num2);
        }
        else if(operation.equals("/")){
            response.setResult(num1/num2);
        }
        else if(operation.equals("^")){
            response.setResult(num1^num2);
        }

        return response;

    }
}
