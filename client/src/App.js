import logo from './logo.svg';
import './App.css';

function App() {
  return (
    <div className="App">
        Hello world!!
      <form method="POST" enctype="multipart/form-data" action="http://localhost:8080/api/json_converter/to_txt">
          <input type="file" name="inputFile" ></input>
          <input type="submit"></input>
      </form>

    </div>
  );
}

export default App;
