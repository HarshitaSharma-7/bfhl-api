package bfhl_api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import bfhl_api.dto.RequestDTO;
import bfhl_api.dto.ResponseDTO;

@Service
public class BfhlServiceImpl implements BfhlService {

    @Override
    public ResponseDTO processData(RequestDTO request) {

        ResponseDTO response = new ResponseDTO();

        List<String> oddNumbers = new ArrayList<>();
        List<String> evenNumbers = new ArrayList<>();
        List<String> alphabets = new ArrayList<>();
        List<String> specialCharacters = new ArrayList<>();

        long sum = 0;

        StringBuilder allLetters = new StringBuilder();

        for (String item : request.getData()) {

            // Number check
            if (item.matches("\\d+")) {

                int num = Integer.parseInt(item);

                sum += num;

                if (num % 2 == 0) {
                    evenNumbers.add(item);
                } else {
                    oddNumbers.add(item);
                }
            }

            // Alphabet check
            else if (item.matches("[a-zA-Z]+")) {

                alphabets.add(item.toUpperCase());

                allLetters.append(item);
            }

            // Special character check
            else {

                specialCharacters.add(item);
            }
        }

        // Reverse + Alternating Caps
        String concatString = buildAlternatingCaps(allLetters.toString());

        response.setIs_success(true);

        // CHANGE THESE 3 VALUES
        response.setUser_id("harshita_sharma_07072005");
        response.setEmail("harshita0768.be23@chitkara.edu.in");
        response.setRoll_number("2310990768");

        response.setOdd_numbers(oddNumbers);
        response.setEven_numbers(evenNumbers);
        response.setAlphabets(alphabets);
        response.setSpecial_characters(specialCharacters);
        response.setSum(String.valueOf(sum));
        response.setConcat_string(concatString);

        return response;
    }

    private String buildAlternatingCaps(String str) {

        StringBuilder result = new StringBuilder();

        String reversed = new StringBuilder(str).reverse().toString();

        for (int i = 0; i < reversed.length(); i++) {

            char ch = reversed.charAt(i);

            if (i % 2 == 0) {
                result.append(Character.toUpperCase(ch));
            } else {
                result.append(Character.toLowerCase(ch));
            }
        }

        return result.toString();
    }
}