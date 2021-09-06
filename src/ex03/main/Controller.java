package ex03.main;

import java.net.URL;
import java.util.ResourceBundle;

import ex03.loginService.LoginService;
import ex03.loginService.LoginServiceImpl;
import ex03.membership.MemberController;
import ex03.membership.MemberService;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Controller implements Initializable{
	private Parent root;
	LoginService ls;
	MemberService ms;
	public void setRoot(Parent root) {
		this.root = root;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ls=new LoginServiceImpl();
		ms=new MemberService();
	}

	public void login() {
		ls.LoginProc(root);
	}

	public void cancel() {
		ls.CancelProc(root);
		
	}

	public void memberAdd() {
		ms.memberShip();
	}

}
