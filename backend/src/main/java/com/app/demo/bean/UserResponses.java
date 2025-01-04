package com.app.demo.bean;

import java.util.List;

public class UserResponses {
    private String username;
    private String startTime;
    private List<ResponseEntry> userResponses;

    public UserResponses() {
        
    }

    public UserResponses(String username, String startTime, List<ResponseEntry> userResponses) {
        this.username = username;
        this.startTime = startTime;
        this.userResponses = userResponses;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public List<ResponseEntry> getUserResponses() {
        return userResponses;
    }

    public void setUserResponses(List<ResponseEntry> userResponses) {
        this.userResponses = userResponses;
    }

    // Inner class for answers
    public static class ResponseEntry 
    {
        private Long questionId;
        private String questionType;
        private String selectedOption;
        private String personalityTrait;

        public ResponseEntry() {
            
        }

        public ResponseEntry(Long questionId, String questionType, String selectedOption, String personalityTrait) {
            this.questionId = questionId;
            this.questionType = questionType;
            this.selectedOption = selectedOption;
            this.personalityTrait = personalityTrait;
        }

        public Long getQuestionId() {
            return questionId;
        }

        public void setQuestionId(Long questionId) {
            this.questionId = questionId;
        }

        public String getQuestionType() {
            return questionType;
        }

        public void setQuestionType(String questionType) {
            this.questionType = questionType;
        }

        public String getSelectedOption() {
            return selectedOption;
        }

        public void setSelectedOption(String selectedOption) {
            this.selectedOption = selectedOption;
        }

        public String getPersonalityTrait() {
            return personalityTrait;
        }

        public void setPersonalityTrait(String personalityTrait) {
            this.personalityTrait = personalityTrait;
        }

		@Override
		public String toString() {
			return "ResponseEntry [questionId=" + questionId + ", questionType=" + questionType + ", selectedOption="
					+ selectedOption + ", personalityTrait=" + personalityTrait + "]";
		}
    }

	@Override
	public String toString() {
		return "UserResponses [username=" + username + ", startTime=" + startTime + ", userResponses=" + userResponses
				+ "]";
	}
    
}

