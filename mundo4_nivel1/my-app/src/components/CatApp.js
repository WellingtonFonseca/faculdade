import React from 'react';
import { Text, View, Image, StyleSheet } from 'react-native';

const CatApp = () => {
  return (
    <View style={styles.container}>
      <Image
        source={{
          uri: 'https://reactnative.dev/docs/assets/p_cat1.png',
        }}
        style={styles.image}
      />
      <Text style={styles.text}>Hello, I am your cat!</Text>
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    alignItems: 'center',
    justifyContent: 'center',
    flex: 1,
  },
  image: {
    width: 200,
    height: 200,
    marginBottom: 10,
  },
  text: {
    fontSize: 18,
    color: 'black',
  },
});

export default CatApp;
