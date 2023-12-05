// 定義城市與區域的資料結構
const districtsData = {
    taipei: ['中正區', '大同區', '中山區', '松山區', '大安區', '萬華區', '信義區', '士林區', '北投區', '內湖區', '南港區'],
    newtaipei: ['板橋區', '新莊區', '中和區', '永和區', '三峽區', '土城區', '樹林區', '汐止區', '淡水區', '三重區'],
};


function updateDistricts() {
	const citySelect = document.getElementById('city');
	const districtSelect = document.getElementById('district');
	const selectedCity = citySelect.value;

	// 清空區域選項
	districtSelect.innerHTML = '<option value="">請選擇區域</option>';

	if (selectedCity && districtsData[selectedCity]) {
		// 將選定城市的區域添加到下拉選單
		districtsData[selectedCity].forEach(district => {
			const option = document.createElement('option');
			option.value = district;
			option.textContent = district;
			districtSelect.appendChild(option);
		});
	}
}