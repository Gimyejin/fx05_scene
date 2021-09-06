package ex03.membership;

import ex03.Member_dto.MemberDTO;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
//여기가 main같은 것이고
public class MembershipServiceImpl implements MembershipService {
	Parent root;
	MemberDTO member;

	public void MembershipServiceImpl() {
		member = new MemberDTO();
	}

	@Override
	public void setRoot(Parent root) {
		this.root = root;

	}

	@Override
	public void memberAdd() {
		
		
		}

	

}
