package UtilityClasses;

import Enum.ExpectedResult;

public class Password{
private String oldPassword;
private String newPassword;
private Boolean oldPasswordMatched;
private String expectedResult;
private String expectedMessage;

public String getOldPassword() {
return oldPassword;
}

public void setOldPassword(String oldPassword) {
this.oldPassword = oldPassword;
}

public String getNewPassword() {
return newPassword;
}

public void setNewPassword(String newPassword) {
this.newPassword = newPassword;
}

public Boolean getOldPasswordMatched() {
return oldPasswordMatched;
}

public void setOldPasswordMatched(Boolean oldPasswordMatched) {
this.oldPasswordMatched = oldPasswordMatched;
}

public String getExpectedResult() {
return expectedResult;
}

public void setExpectedResult(String expectedResult) {
this.expectedResult = expectedResult;
}

public String getExpectedMessage() {
return expectedMessage;
}

public void setExpectedMessage(String expectedMessage) {
this.expectedMessage = expectedMessage;
}

@Override
public String toString() {
	return "Password [oldPassword=" + oldPassword + ", newPassword=" + newPassword + ", oldPasswordMatched="
			+ oldPasswordMatched + ", expectedResult=" + expectedResult + ", expectedMessage=" + expectedMessage + "]";
}



}

