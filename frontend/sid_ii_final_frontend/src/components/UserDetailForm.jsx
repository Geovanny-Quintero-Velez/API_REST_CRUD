import React from 'react';
import { useForm, useFieldArray } from 'react-hook-form';
import ChildrenDataSection from './UserDetailForm/ChildrenDataSection';
import HobbiesDataSection from './UserDetailForm/HobbiesDataSection';
import LocationInput from './UserDetailForm/LocationInput';
import InterestCategories from './UserDetailForm/InterestCategories';
import {getDetail, addDetail, updateDetail} from '../config/api';
import { toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import { useNavigate } from 'react-router-dom';

const UserDetailForm = () => {
  const {
    register,
    control,
    handleSubmit,
    setValue,
    getValues,
    formState: { errors },
  } = useForm({
    defaultValues: {
      id: parseInt(localStorage.getItem('id'),10),
      hijos: [{ nombre: '', edad: '', genero: '' }],
      pasatiempos: [],
      residencia: { ciudad: '', estado: '', pais: '' },
      categoriasDeInteres: [],
    },
  });

  const navigate = useNavigate()

  const id = localStorage.getItem('id');
  console.log("valor de ID" + id);

  const onSubmit = handleSubmit(async data => {
    const response = await getDetail(id);
    const dataExist = response.data && response.data.id;
    if(dataExist){
      await updateDetail(id,data)
        toast.success('Detail updated succesfully',{
            position: "top-center",
            autoClose: 1000,
        })
    }else{
      console.log(data);
      await addDetail(data)
      toast.success('Detail has been created succesfully',{
        position: "top-center",
        autoClose: 1000,
      })
    }
    navigate('/welcome')
  });

  return (
    <div className=' w-screen bg-primary flex justify-center '>
      <div className='w-3/5 flex flex-col items-center bg-second mt-10 rounded-lg h-2/5 mb-4'>
        <h1 className='py-7 font-bold text-white text-xl'>
        Additional information
        </h1>
        <form onSubmit={onSubmit} className='bg-third w-4/5 flex flex-col items-center mb-4'>
          <LocationInput register={register} />
          <hr></hr>
          <ChildrenDataSection control={control} register={register}></ChildrenDataSection>
          <hr></hr>
          <HobbiesDataSection control={control} register={register}></HobbiesDataSection>
          <hr></hr>
          <InterestCategories register={register} />
          <hr></hr>
          <button type="submit" className='py-2 px-10 bg-alter text-white rounded-lg hover:bg-third hover:text-alter hover:border-2 hover:border-alter font-semibold my-5'>Send data</button>
        </form>
      </div>
    </div>
  );

  
};



export default UserDetailForm;
