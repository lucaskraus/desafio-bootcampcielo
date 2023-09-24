import './Components.scss';
import Axios from 'axios';
import { useState, useEffect } from 'react';
import { toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import logo from '../assets/cielo-logo.png';
import critica from '../assets/critica-icon.png';
import elogio from '../assets/elogio-icon.png';
import sugestao from '../assets/sugestao-icon.png';
import FeedbackCard from './FeedbackCard';

const Forms = () => {
    
    //Atualiza a requisição via Axios e envia o feedback quando == true.
    const [query, setQuery] = useState(false);

    //Define o tipo de feedback.
    const [tipoFeedback, setTipoFeedback] = useState("");
    
    //Define a mensagem do feedback.
    const [mensagem, setMensagem] = useState("");

    //State para o card selecionado.
    const [selectedFeedback, setSelectedFeedback] = useState("");

    useEffect(() => {
        if (query) {
            Axios.post("http://localhost:8080/feedback/novo-feedback",{
                mensagem: mensagem,
                tipoFeedback: tipoFeedback
            }).then((response) => {
                if (response.status === 200){
                    toast.success("Seu feedback foi enviado com sucesso!");
                    console.log("Seu feedback foi enviado com sucesso!")
                    setQuery(false);
                };
            }).catch(function(error){
                console.log(error);
            });
        };
    }, [query, tipoFeedback, mensagem] )

    function handleTipoChange(tipo) {
        setSelectedFeedback(tipo);
        setTipoFeedback(tipo);
    }

    function handleMensagem (e) {
        setMensagem(e);
        console.log(tipoFeedback, mensagem);
    }

    function handleSubmit(){
        console.log("está entrando no handlesubmit");
        setQuery(true);
    }

    return(
        <main>
            <div className='formsBox'>
                <img src={logo} width='250px' height='100px' alt='Logo da empresa Cielo'></img>
                <h2>Seu feedback é muito importante para nós!</h2>
                <p>Preencha o formulário abaixo para nos enviar a sua opinião sobre nossos serviços</p>
                <form method='POST'>
                    <label htmlFor='card'>Escolha uma opção:</label>
                    <div className='cardsBox'>
                        <FeedbackCard title={'Sugestão'} url={sugestao} tipo="S" onTipoChange={handleTipoChange} selectedFeedback={selectedFeedback}/>
                        <FeedbackCard title={'Elogio'} url={elogio} tipo="E" onTipoChange={handleTipoChange} selectedFeedback={selectedFeedback}/>
                        <FeedbackCard title={'Crítica'} url={critica} tipo="C" onTipoChange={handleTipoChange} selectedFeedback={selectedFeedback}/>
                    </div>
                    <label htmlFor='mensagem'>Digite abaixo sua mensagem:</label>
                    <textarea type="text" name='mensagem' id='mensagem' onChange={(e) =>{handleMensagem(e.target.value)}}></textarea>   
                </form>

                <button type='submit' id='buttonSubmit' onClick={handleSubmit}>Enviar Feedback</button>
            </div>
        </main>
    )
}

export default Forms;

