function getUploadFile() {
  var input = document.getElementById('uploadFile');
  input.value = input.value + ' Please, select file ';
}

export default getUploadFile;