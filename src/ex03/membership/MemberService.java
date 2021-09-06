package ex03.membership;

import ex03.commonService.CommonService;
import ex03.commonService.CommonServiceImpl;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MemberService {
	private Parent root;
	CommonService cs;
	boolean ch ;
	public void getRoot(Parent root) {
		this.root = root;
	}

	public void memberShip() {
		System.out.println("회원으로 이동");
		try {
			Stage primaryStage =new Stage();
			FXMLLoader loader=new FXMLLoader(getClass().getResource("../main/Membership.fxml"));
			Parent root = loader.load();
			Scene sc = new Scene(root);
			//연결한 컨트롤러를 써야하는 건가봄
			MemberController ct=loader.getController();
			ct.setRoot(root);
			
			primaryStage.setScene(sc);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
