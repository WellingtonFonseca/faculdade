import React from 'react';
import { SafeAreaView } from 'react-native';
import Cafe from '../src/components/Cafe';

const Index = () => {
  return (
    <SafeAreaView style={{ flex: 1, justifyContent: 'center', alignItems: 'center' }}>
      <Cafe />
    </SafeAreaView>
  );
};

export default Index;
