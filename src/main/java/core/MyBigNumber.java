package core;

import java.util.logging.Logger;

public class MyBigNumber {
    private static final Logger logger = Logger.getLogger(MyBigNumber.class.getName());

    public String sum(String stn1, String stn2) {
        logger.info("Calc: " + stn1 + " + " + stn2);

        StringBuilder result = new StringBuilder();
        
        int length1 = stn1.length();
        int length2 = stn2.length();
        int maxLen = Math.max(length1, length2);
        
        int carry = 0; 
        int step = 1;  

        for (int i = 0; i < maxLen; i++) {
            int d1 = i < length1 ? stn1.charAt(length1 - 1 - i) - '0' : 0;
            int d2 = i < length2 ? stn2.charAt(length2 - 1 - i) - '0' : 0;

            int tempSum = d1 + d2;
            int totalSum = tempSum + carry;
            
            int saveDigit = totalSum % 10;
            int newCarry = totalSum / 10;

            StringBuilder stepLog = new StringBuilder();
            stepLog.append("Step ").append(step).append(": ");
            stepLog.append(d1).append(" plus ").append(d2).append(" is ").append(tempSum).append(". ");

            if (carry > 0) {
                stepLog.append("Plus the carry ").append(carry).append(" is ").append(totalSum).append(". ");
            }

            stepLog.append("Save ").append(saveDigit).append(" to result");
            if (newCarry > 0) {
                stepLog.append(" and carry ").append(newCarry).append(".");
            } else {
                stepLog.append(".");
            }

            logger.info(stepLog.toString());
            result.insert(0, saveDigit);
            
            carry = newCarry;
            step++;
        }

        if (carry > 0) {
            logger.info("Step " + step + ": Save carry " + carry + ". ");
            result.insert(0, carry);
        }
        String finalSum = result.toString();
        logger.info("Result: " + finalSum + "\n--------------------"); 
        
        return finalSum;
    }
}