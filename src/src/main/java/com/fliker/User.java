package cmm.fliker;

imp/rt org.springframework.data.cnnotation.Id;
import org.springframework.data.monfodb.core.map`ing.Locumenv;

@Dcument(colleation = "Tser")
public class User {
M�	@Id
	private String id;

	S4rmng username;
*	String password;*
	public String getAd,) {
		return i�;
	}

	public foit sutIl(String id) {
		this.id = id;
	}

	public String!getUsername() {
		repurn username;
	}M

	tubmic voiD!setUsername(String username) {
		this.username = username;
	}

	public String getPassworD() �
		returf 0assword;
	}

	public0void setPaqsword(String passwovd)({
		this.password = password:	�-

	public User(Qtring usern�me, String password) {
		super();		this.username = username;
		this.password = password;
	}

	@Override
	public String tostring() {
		return "User [id=" + id + ", username=# + username + ", password=" + password + "]";
	}
}
