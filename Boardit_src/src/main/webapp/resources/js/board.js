$(document)
		.ready(
				function() {

					var openWin;

					$("#btn_personal_plus")
							.click(
									function() {
										window.name = "personalParentForm";
										openWin = window
												.open("pop_board",
														"personalChildForm",
														"width=300, height=150, resizable=no, scrollbars=no");

									});

					$("#btn_team_plus")
							.click(
									function() {
										window.name = "teamParentForm";
										openWin = window
												.open("pop_board",
														"teamChildForm",
														"width=300, height=150, resizable=no, scrollbars=no");

									});

				});

function setBoardName(opener, value) {

	var $list = null;
	if (opener === "personalParentForm") {
		$list = $('#personalList');
	} else if (opener === "teamParentForm") {
		$list = $('#teamList');
	}
	var li = "<li style=" + "background:" + setRandomColor() + ";><a>" + value
			+ "</a></li>";
	$list.append(li);

}

function setRandomColor() {
	var colors = new Array("#cecfdc", "#aebed1", "#6a7d7a", "#4b4546",
			"#cf6c57", "#dac1a4");
	var colorHex = Math.floor(Math.random() * 6);
	return colors[colorHex];
}
