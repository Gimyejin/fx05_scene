package ex03.loginService;

import ex03.commonService.CommonService;
import ex03.commonService.CommonServiceImpl;
import ex03.main.Controller;
import ex03.membership.MemberController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class LoginServiceImpl implements LoginService{
	CommonService cs = new CommonServiceImpl();
	@Override
	public void LoginProc(Parent root) {
		TextField id = (TextField)root.lookup("#id");
		PasswordField pw=(PasswordField)root.lookup("#pw");
		//System.out.println(id+"/"+pw);
		System.out.println(id.getText());
		System.out.println(pw.getText());
		
	}

	@Override
	public void CancelProc(Parent root) {
		/*
		TextField id = (TextField)root.lookup("#id");
		PasswordField pw=(PasswordField)root.lookup("#pw");
		id.clear();
		pw.clear();
		*/
		cs.setRoot(root);
		cs.WindowClose();
		
	}

	

}
