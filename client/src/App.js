import './App.scss';
import { Card } from './components/Card';

function App() {
  return (
    <div className="App">
      <h1>Hello, World!</h1>
      <div className="cardContainer">
      <Card type={"Elogio"} message={"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus ut semper urna. Quisque euismod arcu vel augue dictum, ut commodo nunc lacinia. Integer ullamcorper dui sit amet purus."}/>
      <Card type={"Sugestão"} message={"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus ut semper urna. Quisque euismod arcu vel augue dictum, ut commodo nunc lacinia. Integer ullamcorper dui sit amet purus."}/>
      <Card type={"Crítica"} message={"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus ut semper urna. Quisque euismod arcu vel augue dictum, ut commodo nunc lacinia. Integer ullamcorper dui sit amet purus."}/>
      </div>
    </div>
  );
}

export default App;
