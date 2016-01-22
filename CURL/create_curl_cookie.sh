curl -k -c cookie.txt https://localhost:8443/my-aktion/rest/organizer/campaign/list
curl -k -c cookie.txt -b cookie.txt --data-urlencode j_username=max@mustermann.de -d j_password=secret https://localhost:8443/my-aktion/j_security_check
