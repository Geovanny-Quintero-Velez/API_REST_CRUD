import React from 'react';
import {useNavigate} from 'react-router-dom'

const WelcomeOptions = () => {

    const navigate = useNavigate()

    const goPage = (num) => {
        if(num==1){
        navigate('/addData')
        }else if(num==2){
        navigate('/makeOrder')  
        }else if(num==3){
          navigate('/listOrders')  
        }
      }

  return (
    <div className="flex flex-col items-center justify-center h-screen bg-primary">
      <button onClick={() => goPage(1)} className="bg-alter text-white font-semibold py-4 px-8 mb-4 hover:bg-gray-50 hover:text-alter hover:font-semibold hover:border-alter hover:border rounded-md">
        Enter Additional User Data
      </button>
      <button onClick={() => goPage(2)} className="bg-alter text-white font-semibold py-4 px-8 hover:bg-gray-50 hover:text-alter hover:font-semibold hover:border-alter hover:border rounded-md">
        Make an Order
      </button>
      <button onClick={() => goPage(3)} className="bg-alter text-white font-semibold py-4 px-8 hover:bg-gray-50 hover:text-alter hover:font-semibold hover:border-alter hover:border rounded-md">
        View my Orders
      </button>
    </div>
  );
};

export default WelcomeOptions;