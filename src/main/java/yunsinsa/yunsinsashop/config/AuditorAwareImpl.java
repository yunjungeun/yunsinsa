package yunsinsa.yunsinsashop.config;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
public class AuditorAwareImpl implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("system");
    }
}
/**
 * 실제로는 Spring Security 또는 다른 인증 메커니즘을 사용하여 현재 사용자를 얻어와야 하는데,
 * 예를 들어, SecurityContextHolder.getContext().getAuthentication().getName()으로 얻어와야한다.
 *
 * 현재 개인프로젝트로는 임시로 "system"을 사용.
 */