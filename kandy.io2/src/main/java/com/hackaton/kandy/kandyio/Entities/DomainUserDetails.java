package com.hackaton.kandy.kandyio.Entities;

/**
 * Created by RanjanD on 3/12/2017.
 */

public class DomainUserDetails
{
        private String user_api_key;

        public String getUserApiKey() { return this.user_api_key; }

        public void setUserApiKey(String user_api_key) { this.user_api_key = user_api_key; }

        private String user_api_secret;

        public String getUserApiSecret() { return this.user_api_secret; }

        public void setUserApiSecret(String user_api_secret) { this.user_api_secret = user_api_secret; }

        private String user_id;

        public String getUserId() { return this.user_id; }

        public void setUserId(String user_id) { this.user_id = user_id; }

        private String domain_name;

        public String getDomainName() { return this.domain_name; }

        public void setDomainName(String domain_name) { this.domain_name = domain_name; }

        private String full_user_id;

        public String getFullUserId() { return this.full_user_id; }

        public void setFullUserId(String full_user_id) { this.full_user_id = full_user_id; }

        private String user_phone_number;

        public String getUserPhoneNumber() { return this.user_phone_number; }

        public void setUserPhoneNumber(String user_phone_number) { this.user_phone_number = user_phone_number; }

        private String user_country_code;

        public String getUserCountryCode() { return this.user_country_code; }

        public void setUserCountryCode(String user_country_code) { this.user_country_code = user_country_code; }
}