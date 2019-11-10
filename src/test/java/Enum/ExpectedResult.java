package Enum;

public enum ExpectedResult {
	Valid("Valid"),
	Invalid("Invalid");
	
	
	private String expectedResult;

	ExpectedResult(String ExpectedResult) {
        this.expectedResult = ExpectedResult;
    }
    
    public String getExpectedResult() {
        return this.expectedResult;
    }

}

