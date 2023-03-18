import { useEffect, useState } from 'react'
import reactLogo from './assets/react.svg'
import './App.css'
import { FoodData } from './interface/FoodData'
import { Card } from './components/card/card';
import { useFoodData } from './hooks/useFoodData';
import { CreateModal } from './components/create-modal/createModal';


function App() {

  const { data } = useFoodData();
  const [isModalOpen, setIsModalOpen] = useState(false);

  const handleOpenModal = () => {
    setIsModalOpen(!isModalOpen);
  }

  return (
    <div className="container">
      <h1>Cardápio Produtos</h1>
      <div className="card-grid">
        {data?.map(foodData =>
          <Card key={foodData.id}
            title={foodData.title}
            image={foodData.image}
            price={foodData.price} />
        )}
      </div>
      {isModalOpen && <CreateModal closeModal={handleOpenModal}/>}
      <button onClick={handleOpenModal}>Novo</button>
    </div>
  )
}

export default App
