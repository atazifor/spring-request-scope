package requestscope.processor;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import requestscope.service.LoggedUserManagementService;

@Component
@RequestScope
public class LoginProcessor {

    private final LoggedUserManagementService loggedUserManagementService;
    public LoginProcessor(LoggedUserManagementService loggedUserManagementService)  {
        this.loggedUserManagementService  = loggedUserManagementService;
    }
    private String  username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public boolean login() {
        String username = this.getUsername();
        String password = this.getPassword();
        if("amin".equals(username) && "password".equals(password)) {
            loggedUserManagementService.setUsername(username);
            return true;
        }
        else return false;
    }
}
