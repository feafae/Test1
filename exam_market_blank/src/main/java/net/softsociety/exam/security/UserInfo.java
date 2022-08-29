package net.softsociety.exam.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;
import net.softsociety.exam.domain.Member;

@Data
public class UserInfo implements UserDetails {
	
	private Member member; 

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// 사용자의 권한을 리턴
        Collection<GrantedAuthority> collect = new ArrayList<>();
        collect.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                
                return member.getRolename();
            }
        });
        return collect;
	}

	@Override
	public String getPassword() {
		return member.getMemberpw();
	}

	@Override
	public String getUsername() {
		return member.getMemberid();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
