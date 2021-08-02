import React from 'react';
import getUploadFile from './getElementById';

class FileForm extends React.Component {
    constructor(props) {
      super(props);
      this.state = {value: ''};
      this.handleChange = this.handleChange.bind(this);
      this.handleSubmit = this.handleSubmit.bind(this);
    }
  
    handleChange(event) { this.setState({value: event.target.value}); }
    handleSubmit(event) {
      getUploadFile();
      alert('JSON file was uploaded: ' + this.state.value);
      event.preventDefault();
    }
  
    render() {
      return (
        <form className="form-input-file" 
              method="POST" 
              enctype="multipart/form-data" 
              action="http://localhost:8080/api/json_converter/to_txt" 
              onSubmit={this.handleSubmit}>

          <label> Please, select JSON file  </label>
          
            <input type="file"
             name="inputFile" 
             id="inputFiled" 
             value={this.state.value} 
             onChange={this.handleChange} />       
          <input type="submit" value="Submit" id="submitButton" />
        </form>
      );
    }
  }

export default FileForm;