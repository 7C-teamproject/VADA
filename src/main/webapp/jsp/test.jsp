<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

github test
	<form method="post" action="/Vada/fileupload" enctype="multipart/form-data" accept-charset="utf-8">
		<input type="hidden" name="command" value="write"/>
		<table class="table table-stripped"
			style="text-align: center; boarder: 1px solid #dddddd">
			<thead>
				<tr>
					<th colspan="2"
						style="background-color: #eeeeee; text-align: center;">글 작성하기</th>
				</tr>
				<tr>
				</tr>
				<tr>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td style="float: left">첨부파일 : <input type="file"
						name="file1" /><br />
				</tr>
				<tr>
					<td style="float: left">첨부파일 : <input type="file"
						name="file2" /><br />
				</tr>
				<tr>
					<td style="float: left">첨부파일 : <input type="file"
						name="file3" /><br />
				</tr>
			</tbody>
		</table>
		<input type="submit" class="btn btn-primary pull-right" value="등록">
	</form>
</body>
</html>