import React from 'react'
import {BrowserRouter, Route, Routes, Navigate} from 'react-router-dom'

import { ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import RoutesC from './components/RoutesC';

const App = () => {

  return (
    <div>
    <RoutesC></RoutesC>
    </div>
  )
}

export default App