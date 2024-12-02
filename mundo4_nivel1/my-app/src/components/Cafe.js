import React from 'react';
import { Text, View, StyleSheet } from 'react-native';

const Cat = (props) => {
  return (
    <View style={styles.catContainer}>
      <Text style={styles.text}>Hello, I am {props.name}!</Text>
    </View>
  );
};

const Cafe = () => {
  return (
    <View style={styles.container}>
      <Cat name="Maru" />
      <Cat name="Jellylorum" />
      <Cat name="Spot" />
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    padding: 20,
    alignItems: 'center',
  },
  catContainer: {
    marginVertical: 10,
  },
  text: {
    fontSize: 18,
  },
});

export default Cafe;
