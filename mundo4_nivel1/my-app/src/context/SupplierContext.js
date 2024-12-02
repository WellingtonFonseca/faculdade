import React, { createContext, useState, useEffect } from 'react';
import AsyncStorage from '@react-native-async-storage/async-storage';

export const SupplierContext = createContext();

export const SupplierProvider = ({ children }) => {
  const [suppliers, setSuppliers] = useState([]);
  const [isLoading, setIsLoading] = useState(true);

  // Carregar fornecedores do armazenamento ao iniciar o app
  useEffect(() => {
    const loadSuppliersFromStorage = async () => {
      try {
        const storedSuppliers = await AsyncStorage.getItem('suppliers');
        if (storedSuppliers) {
          console.log('Fornecedores carregados:', JSON.parse(storedSuppliers)); // Verifique se a imagem está incluída
          setSuppliers(JSON.parse(storedSuppliers));
        }
      } catch (error) {
        console.error('Erro ao carregar fornecedores:', error);
      } finally {
        setIsLoading(false);
      }
    };
  
    loadSuppliersFromStorage();
  }, []);

  // Salvar a lista de fornecedores no armazenamento
  const saveSuppliersToStorage = async (updatedSuppliers) => {
    try {
      await AsyncStorage.setItem('suppliers', JSON.stringify(updatedSuppliers));
    } catch (error) {
      console.error('Erro ao salvar fornecedores:', error);
    }
  };

  // Adicionar um fornecedor e salvar no armazenamento
  const addSupplier = (supplier) => {
    const updatedSuppliers = [
      ...suppliers,
      { ...supplier, id: String(suppliers.length + 1) },
    ];
    console.log('Fornecedores atualizados:', updatedSuppliers); // Verifique se a imagem está incluída
    setSuppliers(updatedSuppliers);
    saveSuppliersToStorage(updatedSuppliers);
  };

  const updateSupplier = (updatedSupplier) => {
    const updatedSuppliers = suppliers.map((supplier) =>
      supplier.id === updatedSupplier.id ? updatedSupplier : supplier
    );
    setSuppliers(updatedSuppliers);
    saveSuppliersToStorage(updatedSuppliers);
  };
  
  return (
    <SupplierContext.Provider value={{ suppliers, addSupplier, updateSupplier, isLoading }}>
      {children}
    </SupplierContext.Provider>
  );
};


// const clearStorage = async () => {
//   try {
//     await AsyncStorage.removeItem('suppliers');
//     console.log('Lista de fornecedores deletada com sucesso!');
//   } catch (error) {
//     console.error('Erro ao deletar fornecedores:', error);
//   }
// };

// // Chame a função ao iniciar o aplicativo para testar
// clearStorage();