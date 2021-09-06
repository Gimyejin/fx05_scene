package ex03.membership;

import java.net.URL;
import java.util.ResourceBundle;

import ex03.Member_dto.MemberDTO;
import ex03.commonService.CommonService;
import ex03.commonService.CommonServiceImpl;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class MemberController implements Initializable {
	Parent root;
	CommonService cs;
	MembershipService ms;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		cs = new CommonServiceImpl();
		ms = new MembershipServiceImpl();

	}

	public void setRoot(Parent root) {
		this.root = root;
		addComboBox();

	}

	public void memberAdd() {// membershipProc() //회원가입 버튼 클릭시

		MemberDTO dto = new MemberDTO();
		check(dto);
		int num =getHobby();
		printHobby(num);
		dto.setName(((TextField) root.lookup("#fxname")).getText());
		dto.setId(((TextField) root.lookup("#fxid")).getText());
		dto.setPw(((PasswordField) root.lookup("#fxpw")).getText());

		dto.setAge(getComboBox());
		dto.setGender(getGender());

		System.out.println(dto.getName());
		System.out.println(dto.getAge());
		if (dto.getGender())
			System.out.println("남성");
		else
			System.out.println("여성");

		ms.setRoot(root);
		ms.memberAdd();

	}public void printHobby(int num) {
		System.out.print("취미: ");
		if(num==1) {
			System.out.print("음악");
		}else if(num==2) {
			System.out.println("스포츠");
		}else if(num==3) {
			System.out.println("음악, 스포츠");
		}else if(num==4) {
			System.out.println("영화");
		}else if(num==5) {
			System.out.println("스포츠, 영화");
		}else if(num==6) {
			System.out.println("음악, 스포츠,영화");
		}
	}

	 public int getHobby() {
         int hobby = 0;
         CheckBox music = (CheckBox)root.lookup("#chkmusic");
         CheckBox sport = (CheckBox)root.lookup("#chksport");
         CheckBox movie = (CheckBox)root.lookup("#chkmovie");
         if(music.isSelected()) { hobby+=1; }
         if(sport.isSelected()) { hobby+=2; }
         if(movie.isSelected()) { hobby+=4; }
         /*
          hobby에 1이 들어와 있으면 음악을 선택
          hobby에 3이 들어와 있으면 음악과 스포츠
          hobby에 6이 들어와 있으면 스포츠, 영화 선택
          ....
          */
         return hobby;
 }
	public void check(MemberDTO dto) {
		TextField tx = (TextField) root.lookup("#fxname");
		PasswordField pf = (PasswordField) root.lookup("#fxpw");
		TextField txid = (TextField) root.lookup("#fxid");
		if (tx.getText().isEmpty()) {
			cs.alter("이름을 입력하시오");
			tx.requestFocus();
		} else if (pf.getText().isEmpty()) {
			cs.alter("비밀번호를 입력하시오");
			pf.requestFocus();
		} else if (txid.getText().isEmpty()) {
			cs.alter("아이디를 입력하시오");
			txid.requestFocus();
		}
	}

	public boolean getGender() {
		RadioButton fxman = (RadioButton) root.lookup("#fxman");
		if (fxman.isSelected())
			return true;
		else
			return false;
	}

	public void memberCancel() {
		cs.setRoot(root);
		cs.WindowClose();
	}

	public String getComboBox() {

		ComboBox<String> cmbAge = (ComboBox<String>) root.lookup("#cmbAge");
		// System.out.println("cmbAge : "+cmbAge);
		// System.out.println("cmbAge.value : "+cmbAge.getValue());
		String age = null;
		if (cmbAge.getValue() == null) {
			System.out.println("콤보박스를 선택해 주세요");
		} else {
			age = cmbAge.getValue().toString();
		}
		return age;
	}

	public void addComboBox() {
		ComboBox<String> cmbAge = (ComboBox<String>) root.lookup("#cmbAge");
		if (cmbAge != null) {
			cmbAge.getItems().addAll("20대 미만", "20대", "30대", "40대 이상");
		}
	}
}
