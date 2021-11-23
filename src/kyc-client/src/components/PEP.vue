<template>
    <div class="notification is-primary mt-2 mb-2">
        <p class="is-size-4">{{ person }}</p>
    </div>
</template>

<script>
export default {
  props: {
    person: [Object, String, Array]
  }
};
</script>
