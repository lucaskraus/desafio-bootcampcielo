import './App.scss';
import { Card } from './components/Card';

function App() {
  const cards = [
    {
      id: 1,
      type: "Elogio",
      message: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus ut semper urna. Quisque euismod arcu vel augue dictum, ut commodo nunc lacinia. Integer ullamcorper dui sit amet purus.",
      status: "Recebido"
    },
    {
      id: 2,
      type: "Sugestão",
      message: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus ut semper urna. Quisque euismod arcu vel augue dictum, ut commodo nunc lacinia. Integer ullamcorper dui sit amet purus.",
      status: "Em processamento"
    },
    {
      id: 3,
      type: "Crítica",
      message: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus ut semper urna. Quisque euismod arcu vel augue dictum, ut commodo nunc lacinia. Integer ullamcorper dui sit amet purus.",
      status: "Finalizado"
    },
  ]

  return (
    <div className="App">
      <h1>Hello, World!</h1>
      <div className="cardContainer">
      {
        cards.map(card => <Card key={card.id} content={card}/>)
      }
      
      </div>
    </div>
  );
}

export default App;
