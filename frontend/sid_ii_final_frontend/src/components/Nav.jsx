import React from 'react'
import {useNavigate} from 'react-router-dom'

const Nav = () => {

  const navigate = useNavigate()


  const handleLogout = () => {
    localStorage.removeItem('user');
    localStorage.removeItem('id');
    window.location.href = '/'; 
  };


  const username = localStorage.getItem('user');

  return (
    <>
    <nav className='bg-primary h-16'>
      <div className='flex justify-between items-center'>
        <h1 className='ml-16 mt-4 text-white text-2xl'>Welcome to sales system {username}</h1>
        <div className='text-end mr-16 mt-4'>
          <button onClick={handleLogout} className='bg-second py-2 px-4 text-white rounded-md hover:bg-alter '>Cerrar Sesion</button>
        </div>
      </div>
    </nav>
    </>
  )
}

export default Nav