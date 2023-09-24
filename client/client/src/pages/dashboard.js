import { useEffect, useCallback, useState } from "react";
import { Card } from "../components/Card"
import { api } from "../lib/axios"

export function Dashboard(){
  const [cards, setCards] = useState([]);
  
  
  const fetchFeedback = useCallback(async () => {
    try {
      const {data} = await api.get("/feedback/")
      setCards(data)
    } catch (e) {
      console.log(e)
    }   
    
  }, []) 

  useEffect(() => {
    fetchFeedback()
  }, [fetchFeedback])
    
  return (
    <div className="cardContainer">
      <h1 className="title">Dashboard</h1>       
      {
        cards.map(card => <Card key={card.id} content={card}/>)
      }
  </div>
  )
}