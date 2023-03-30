package hello.login.domain.login;

import org.springframework.stereotype.Service;

import hello.login.domain.member.Member;
import hello.login.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginService {

	private final MemberRepository memberRepository;

	/**
	 * @return null 로그인 실패
	 */
	public Member login(String loginId, String password) {
		/*
		Optional<Member> findMemberOptional = memberRepository.findByLoginId(loginId);
		if (findMemberOptional.get().getPassword().equals(password)) {
			return findMemberOptional.get();
		} else {
			return null;
		}
		*/
		return memberRepository.findByLoginId(loginId)
			.filter(m -> m.getPassword().equals(password))
			.orElse(null);
	}

}
