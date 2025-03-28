package bouda.med.company.auditing;

import java.util.Optional;


import bouda.med.company.user.User;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class ApplicationAuditAware implements AuditorAware<Object>  {

    @Override

    public Optional<Object> getCurrentAuditor() {
    Authentication authentication =
            SecurityContextHolder
                    .getContext()
                    .getAuthentication();
    if (authentication == null ||
        !authentication.isAuthenticated() ||
            authentication instanceof AnonymousAuthenticationToken
    ) {
        return Optional.empty();
    }

    User userPrincipal = (User) authentication.getPrincipal();
    return Optional.ofNullable(userPrincipal.getId());
}
    
    
    
}
