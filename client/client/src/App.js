import { BrowserRouter } from 'react-router-dom';
import './App.scss';
import { Router } from './Router';
import { ToastContainer } from 'react-toastify';

function App() {
  
  return (
    <BrowserRouter>
      <div className="App">
        <Router/>
        <ToastContainer position="top-center"/>
      </div>
    </BrowserRouter>
  );
}

export default App;
