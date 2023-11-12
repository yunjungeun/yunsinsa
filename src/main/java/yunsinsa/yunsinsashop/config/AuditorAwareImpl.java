package yunsinsa.yunsinsashop.config;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        // 여기에서 현재 사용자의 ID 또는 이름을 반환하도록 구현
        // 실제로는 Spring Security 또는 다른 인증 메커니즘을 사용하여 현재 사용자를 얻어와야 합니다.
        // 예를 들어, SecurityContextHolder.getContext().getAuthentication().getName()을 사용할 수 있습니다.
        return Optional.of("system"); // 임시로 "system"을 사용했습니다.
    }
}
