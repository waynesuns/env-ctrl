//获取32位长度的Guid号
function NewGuid() {
	var guid = GetRandomString(8) + "-" + GetRandomString(4) + "-" + GetRandomString(4) + "-" + GetRandomString(4)
		+ "-" + GetRandomString(16);
	return guid;
}
// 获取任意长度的随机（字符和数字）串
function GetRandomString(length) {
	var rand = "";
	for ( var i = 0; i < length; i++) {
		if (i % 2 == 0) {
			rand += String.fromCharCode(Randomletter());
		} else {
			rand += RandomNumber();
		}
	}
	return rand;
}
// 获取65-90的随机数用于根据Ascall码表产生随机大写字母
function Randomletter() {
	var rand = Math.floor(Math.random() * 25) + 65;
	return rand;
}
// 获取0-9的随机数
function RandomNumber() {
	var rand = Math.floor(Math.random() * 9);
	return rand;
}