import React from 'react';
import { SafeAreaView } from 'react-native';
import CatApp from '../src/components/CatApp';

const Index = () => {
  return (
    <SafeAreaView style={{ flex: 1 }}>
      <CatApp />
    </SafeAreaView>
  );
};

export default Index;
