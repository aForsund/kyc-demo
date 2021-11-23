<template>
    <div class="notification is-primary mt-2 mb-2">
        <p class="is-size-2">{{ person.name }}</p>
        <p class="is-size-4">{{ person.date.year }}-{{ person.date.month }}-{{ person.date.day }}</p>
        <div>
          <div v-for="(dataset, index) in person.dataset" :key="index">
            <p class="is-size-3">{{ dataset.dataset }}</p>
            <p class="is-size-5">{{ dataset.score }}</p>
          </div>
        </div>
       
    </div>
</template>

<script>
export default {
  props: {
    person: [Object, String, Array]
  }
};
</script>
