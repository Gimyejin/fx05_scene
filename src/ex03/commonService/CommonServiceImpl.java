package ex03.commonService;

import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class CommonServiceImpl implements CommonService {
	Parent root;
	Alert alter;

	@Override
	public void setRoot(Parent root) {
		this.root = root;

	}

	@Override
	public void WindowClose() {
		Stage stage = (Stage) root.getScene().getWindow();
		stage.close();

	}

	@Override
	public void alter(String msg) {
		alter = new Alert(AlertType.INFORMATION);
		alter.setTitle("error");
		alter.setHeaderText("입력 창");
		alter.setContentText(msg);
		alter.show();
	}

}
